package net.voznjuk.ui;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	}
	,
	USERS {
		{
			this.command = new UsersCommand();
		}
	}
	,
	USER {
		{
			this.command = new UserCommand();
		}
	}
	,
	PRODUCTS {
		{
			this.command = new ProductsCommand();
		}
	}
	,
	PRODUCT {
		{
			this.command = new ProductCommand();
		}
	}
	;

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
