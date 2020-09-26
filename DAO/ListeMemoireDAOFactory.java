package DAO;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public CategorieDAO getCategorieDAO() {
		return ListeMemoireCategorieDAO.getInstance();
	}
}
