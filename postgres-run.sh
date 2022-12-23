docker run -d --rm -p 6664:5432 \
      -e POSTGRES_DB=sk_example_db \
      -e POSTGRES_USER=sk_example_user \
      -e POSTGRES_PASSWORD=admin \
      postgres:14