/*
 * This file is part of Craftconomy3.
 *
 * Copyright (c) 2011-2013, Greatman <http://github.com/greatman/>
 *
 * Craftconomy3 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Craftconomy3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Craftconomy3.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.greatmancode.craftconomy3.commands.money;

import com.greatmancode.craftconomy3.Common;
import com.greatmancode.tools.commands.interfaces.CommandExecutor;

public class DeleteCommand extends CommandExecutor {
	@Override
	public void execute(String sender, String[] args) {
		if (Common.getInstance().getAccountManager().delete(args[0])) {
			Common.getInstance().getServerCaller().getPlayerCaller().sendMessage(sender, Common.getInstance().getLanguageManager().parse("money_delete_success", args[0]));
		} else {
			Common.getInstance().getServerCaller().getPlayerCaller().sendMessage(sender, Common.getInstance().getLanguageManager().getString("account_not_exist"));
		}
	}

	@Override
	public String help() {
		return Common.getInstance().getLanguageManager().getString("money_delete_cmd_help");
	}

	@Override
	public int maxArgs() {
		return 1;
	}

	@Override
	public int minArgs() {
		return 1;
	}

	@Override
	public boolean playerOnly() {
		return false;
	}

	@Override
	public String getPermissionNode() {
		return "craftconomy.account.delete";
	}
}
