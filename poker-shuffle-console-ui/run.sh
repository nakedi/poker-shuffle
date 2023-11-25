# Make sure java is installed
if ! command -v java
then
    echo "java could not be found. Please make sure the environment is setup"
    exit 1
fi

mvn spring-boot:run