# Frontend Dockerfile
# Step 1: Build React app
FROM node:16-alpine AS build

WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the code
COPY . .

# Build the React app
RUN npm run build

# Step 2: Serve the app with Nginx
FROM nginx:alpine

# Copy build output to Nginx's HTML folder
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
