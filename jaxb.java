@XmlRootElement
public class Database {
	@XmlElementWrapper(name="records")
	@XmlElement(name="data")
    List<Data> records = new ArrayList<Data>();

    public List<Data> getRecords(){
		return records; 
	}
    public void setRecords(List<Data> records){ 
		this.records = records; 
	}
}


// @XmlRootElement
public class Data 
{
    String name;
    String address;

    public String getName(){ 
		return name;      
	}
    public void setName(String name) {
		this.name = name; 
	}

    public String getAddress() { 
		return address;         
	}
    public void setAddress(String address) {
		this.address = address; 
	}
}


public class Test
{
    public static void main(String args[]) throws Exception
    {
        Data data1 = new Data();
             data1.setName("Peter");
             data1.setAddress("Cologne");

        Data data2 = new Data();
             data2.setName("Mary");
             data2.setAddress("Hamburg");

        Database database = new Database();
                 database.getRecords().add(data1);
                 database.getRecords().add(data2);

        JAXBContext context = JAXBContext.newInstance(Database.class);
        Marshaller marshaller = context.createMarshaller();
                   marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                   marshaller.marshal(database, new FileWriter("test.xml"));   

       JAXBContext contextB = JAXBContext.newInstance(Database.class);
       Unmarshaller unmarshallerB = contextB.createUnmarshaller();
       JAXBElement<Database> jaxbElementB = unmarshallerB.unmarshal("test.xml", Database.class);

       Database db = jaxbElementB.getValue();
				   
    }
}