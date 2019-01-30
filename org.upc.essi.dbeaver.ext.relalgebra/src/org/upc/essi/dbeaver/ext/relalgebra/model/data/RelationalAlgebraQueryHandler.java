/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2019 Serge Rider (serge@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.upc.essi.dbeaver.ext.relalgebra.model.data;

import org.jkiss.code.NotNull;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.data.DBDCollection;
import org.jkiss.dbeaver.model.exec.DBCException;
import org.jkiss.dbeaver.model.exec.DBCExecutionSource;
import org.jkiss.dbeaver.model.exec.DBCResultSet;
import org.jkiss.dbeaver.model.exec.DBCSession;
import org.jkiss.dbeaver.model.exec.DBCStatement;
import org.jkiss.dbeaver.model.exec.jdbc.JDBCPreparedStatement;
import org.jkiss.dbeaver.model.exec.jdbc.JDBCSession;
import org.jkiss.dbeaver.model.impl.jdbc.data.JDBCCollection;
import org.jkiss.dbeaver.model.impl.jdbc.data.handlers.JDBCArrayValueHandler;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.jkiss.dbeaver.model.struct.DBSTypedObject;

import java.sql.Array;
import java.sql.SQLException;
import java.sql.Types;

public class RelationalAlgebraQueryHandler implements DBCStatement {

	@Override
	public void cancelBlock(DBRProgressMonitor monitor, Thread blockThread) throws DBException {
		System.out.println("cancelBlock()");

		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		System.out.println("close()");

		// TODO Auto-generated method stub
		
	}

	@Override
	public DBCSession getSession() {
		System.out.println("getSession()");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueryString() {
		System.out.println("getQueryString()");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBCExecutionSource getStatementSource() {
		System.out.println("getStatementSource()");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatementSource(DBCExecutionSource source) {
		System.out.println("setStatementSource()");

		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean executeStatement() throws DBCException {
		System.out.println("executeStatement()");

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addToBatch() throws DBCException {
		System.out.println("addToBatch()");

		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] executeStatementBatch() throws DBCException {
		System.out.println("executeStatementBatch()");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBCResultSet openResultSet() throws DBCException {
		System.out.println("openResultSet()");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBCResultSet openGeneratedKeysResultSet() throws DBCException {
		System.out.println("openGeneratedKeysResultSet()");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUpdateRowCount() throws DBCException {
		System.out.println("getUpdateRowCount()");

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean nextResults() throws DBCException {
		System.out.println("nextResults()");

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLimit(long offset, long limit) throws DBCException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Throwable[] getStatementWarnings() throws DBCException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatementTimeout(int timeout) throws DBCException {
		// TODO Auto-generated method stub
		
	}
    
}
