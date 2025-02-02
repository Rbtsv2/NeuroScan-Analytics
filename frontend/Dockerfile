# Étape 1 : Build de l'application Angular
FROM node:18 AS build

WORKDIR /app

# Copie des fichiers de configuration d'Angular
COPY package.json package-lock.json ./
RUN npm install

# Copie du code source Angular
COPY . .

# Build de l'application pour la production
RUN npm run build --prod

# Étape 2 : Serveur NGINX pour héberger l'application Angular
FROM nginx:alpine

# Copie des fichiers buildés dans le dossier de NGINX
COPY --from=build /app/dist /usr/share/nginx/html

# Exposition du port 80 (le port par défaut de NGINX)
EXPOSE 80

# Démarrage de NGINX en mode foreground
CMD ["nginx", "-g", "daemon off;"]
