FROM node:20 as build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build -- --project barber-citas --configuration production

# Stage Nginx
FROM nginx:alpine
# Copia la carpeta browser, que contiene index.html
COPY --from=build /app/dist/barber-citas/browser/ /usr/share/nginx/html/

COPY nginx.conf /etc/nginx/conf.d/default.conf
