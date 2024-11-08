FROM node:22.2.0-alpine3.20
WORKDIR /app

COPY package.json .
COPY package-lock.json .

RUN npm install

COPY . .

RUN npm run build

ENTRYPOINT ["npm", "run", "dev"]
