package common.factory.jdbcFactory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ListFactory;
import persistent.Cart;
import persistent.WishList;
import persistent.jdbc.JDBCCart;
import persistent.jdbc.JDBCWishList;

public class JDBCListFactory extends ListFactory{

	@Override
	public WishList buildWishList(int ID) throws ErrorConnectionException, AlertDriver {
		return new JDBCWishList(ID);
	}

	@Override
	public Cart buildCart(int ID) throws ErrorConnectionException, AlertDriver {
		return new JDBCCart(ID);
	}

}