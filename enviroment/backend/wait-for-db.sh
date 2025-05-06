#!/bin/bash
set -e

HOST="$DATABASE_HOST"
PORT="$DATABASE_PORT"
DB="$DATABASE_NAME"
USER="$DATABASE_USER"
PASSWORD="$DATABASE_PASSWORD"

until PGPASSWORD="$PASSWORD" psql -h "$HOST" -p "$PORT" -U "$USER" -d "$DB" -c '\q'
do
    echo "Esperando pelo PostgreSQL em $HOST:$PORT..."
    sleep 10
done

echo "PostgreSQL está pronto. Iniciando a aplicação Spring Boot..."
exec "$@"