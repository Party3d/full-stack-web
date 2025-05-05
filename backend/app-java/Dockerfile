# Etapa 1: build da aplicação
FROM node:18 AS builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

# Etapa 2: Nginx serve os arquivos
FROM nginx:alpine
COPY --from=builder /app/dist/web-angular/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

