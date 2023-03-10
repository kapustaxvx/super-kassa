package com.sk.superkassa.service;

import com.sk.superkassa.exception.NoSuchElementException;
import com.sk.superkassa.lock.AutoCloseableReentrantLock;
import com.sk.superkassa.lock.LocksProvider;
import com.sk.superkassa.model.dto.ModifyRequest;
import com.sk.superkassa.model.dto.Value;
import com.sk.superkassa.model.entity.Element;
import com.sk.superkassa.repo.ElementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ElementServiceImpl implements ElementService {

    private final static Logger logger = LoggerFactory.getLogger(ElementServiceImpl.class);

    private final ElementRepository elementRepository;

    private final LocksProvider locksProvider;
    private static volatile boolean sleep = true;

    public ElementServiceImpl(ElementRepository elementRepository, LocksProvider locksProvider) {
        this.elementRepository = elementRepository;
        this.locksProvider = locksProvider;
    }

    @Override
    @Transactional
    public Value modifyValue(ModifyRequest request) {
        try (final AutoCloseableReentrantLock lock = locksProvider.provideModifyLock(request.getId()).open()){
            logger.info("Modify request: id = {}, add = {}", request.getId(), request.getAdd());
            Optional<Element> elementOpt = elementRepository.findById(request.getId());
            if (elementOpt.isEmpty()) {
                logger.error("There is no element with id: {}", request.getId());
                throw new NoSuchElementException("There is no element with id: " + request.getId());
            }
            if (sleep) {
                logger.info("Спим 5 секунд");
                sleep = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                logger.info("Не спим");
                sleep = true;
            }
            Element element = elementOpt.get();
            AtomicLong current = elementOpt.get().getValue().getCurrent();
            current.addAndGet(request.getAdd());
            element.setValue(new Value(current));
            Element elementToUpdate = elementRepository
                    .save(element);
            logger.info("Element [{}] updated: current value = {}",
                    request.getId(), elementToUpdate.getValue().getCurrent());
            return elementToUpdate.getValue();
        }
    }

    @Override
    public Value getById(Long id) {
        logger.info("Get value by id:[{}]", id);
        Optional<Element> element = elementRepository.findById(id);
        if (element.isEmpty()) {
            logger.error("There is no element with id: {}", id);
            throw new NoSuchElementException("There is no element with id: " + id);
        }
        return elementRepository.findById(id).orElseThrow().getValue();
    }
}
