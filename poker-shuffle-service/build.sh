# Make sure java is installed
if ! command -v java
then
    echo "java could not be found. Please make sure the environment is setup"
    exit 1
fi
# Make sure maven is installed
if ! command -v mvn
then
    echo "maven could not be found. Please make sure the environment is setup"
    exit 1
fi

echo " Run maven build ..."
echo ""
mvn clean install
echo " Run maven test ..."
echo ""
mvn test