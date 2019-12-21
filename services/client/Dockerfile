FROM node:10.18.0-alpine
WORKDIR /usr/src/app
ENV PATH /usr/src/app/node_modules/.bin:$PATH
# install and cache app dependencies
COPY ./package.json /usr/src/app/package.json
COPY ./package-lock.json /usr/src/app/package-lock.json
RUN npm ci --silent
# Seems to be an issue with Alpine based images using Pipelines and React 2 Node
# Fix recommendation found here:
# https://stackoverflow.com/questions/52196518/could-not-get-uid-gid-when-building-node-docker
# Atlassian issue raised here:
# https://bitbucket.org/site/master/issues/16846/npm-error-eacces-permission-denied
RUN npm config set unsafe-perm true
# Set environment variables at BUILD TIME
ARG NODE_ENV
ENV NODE_ENV $NODE_ENV
# Prevent NODE from running out of memory which by default is just 512
RUN export NODE_OPTIONS=--max_old_space_size=2048
CMD ["npm", "start"]
