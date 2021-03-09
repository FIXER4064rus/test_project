package maksim_klimenko1.buisnessObjectsAndStaticFactory;

public class EmailObjectFactory {

    public static EmailObject createSimple() {
        EmailObject emailObject = new EmailObject();
        emailObject.setCompanyName("Autotest");
        emailObject.setFirstName("Autotest");
        emailObject.setLastName("Autotest");
        return emailObject;
    }

    public static EmailObject createWithCustomCompany(String compName) {
        EmailObject emailObject = createSimple();
        emailObject.setCompanyName(compName);
        return emailObject;
    }


}
