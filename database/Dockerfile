FROM mysql:5.7

# Copy the database initialize script: 
# Contents of /docker-entrypoint-initdb.d are run on mysqld startup
ADD  docker-entrypoint-initdb.d/ /docker-entrypoint-initdb.d/

# Default values for passwords and database name. Can be overridden on docker run
ENV MYSQL_ROOT_PASSWORD=password
ENV MYSQL_DATABASE=bikeo
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=admin
