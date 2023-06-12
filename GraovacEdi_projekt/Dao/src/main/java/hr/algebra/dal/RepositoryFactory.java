package hr.algebra.dal;

import hr.algebra.dal.sql.SqlRepository;

public class RepositoryFactory {
    private RepositoryFactory() {
    }
    
    public static IRepository getRepository() throws Exception {
        //return new FileRepository();
        return new SqlRepository();
    }
}
