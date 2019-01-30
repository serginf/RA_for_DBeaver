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
package org.upc.essi.dbeaver.ext.relalgebra.model;

import java.util.Collection;
import java.util.Collections;

import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.ext.postgresql.model.PostgreDialect;
import org.jkiss.dbeaver.model.DBPDataSource;
import org.jkiss.dbeaver.model.DBPDataSourceContainer;
import org.jkiss.dbeaver.model.DBPDataSourceInfo;
import org.jkiss.dbeaver.model.connection.DBPConnectionConfiguration;
import org.jkiss.dbeaver.model.exec.DBCExecutionContext;
import org.jkiss.dbeaver.model.exec.DBCExecutionPurpose;
import org.jkiss.dbeaver.model.exec.DBCSession;
import org.jkiss.dbeaver.model.impl.AbstractExecutionContext;
import org.jkiss.dbeaver.model.qm.QMUtils;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.jkiss.dbeaver.model.sql.SQLDataSource;
import org.jkiss.dbeaver.model.sql.SQLDialect;
import org.jkiss.dbeaver.model.struct.DBSInstance;
import org.jkiss.dbeaver.model.struct.DBSObject;
import org.upc.essi.dbeaver.ext.relalgebra.RelAlgebraUtils;

public class RelAlgebraDataSource implements DBPDataSource, DBSInstance, DBCExecutionContext, SQLDataSource {

    private final DBPDataSourceContainer container;
    private final SQLDialect dialect;
    private final long id;

    public RelAlgebraDataSource(DBPDataSourceContainer container) throws DBException {
    	RelAlgebraUtils.log.debug("Constructor de RelAlgebraDataSource");
    	this.container = container;
        this.dialect = new RelAlgebraSQLDialect();//PostgreDialect();
        this.id = AbstractExecutionContext.generateContextId();
        QMUtils.getDefaultHandler().handleContextOpen(this, false);
   }

    @Override
    public DBSInstance getDefaultInstance() {
        return this;
    }

    @Override
    public Collection<? extends DBSInstance> getAvailableInstances() {
        return Collections.singletonList(this);
    }

    @Override
    public void shutdown(DBRProgressMonitor monitor)
    {
        this.close();
    }

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public DBSObject getParentObject() {
		return container;
	}

	@Override
	public DBPDataSource getDataSource() {
		return this;
	}

	@Override
	public String getName() {
        return container.getName();
	}

	@Override
	public boolean isPersisted() {
		return true;
	}

	@Override
	public void close() {
		QMUtils.getDefaultHandler().handleContextClose(this);
	}

	@Override
	public SQLDialect getSQLDialect() {
		return dialect;
	}

	@Override
	public long getContextId() {
		return this.id;
	}

	@Override
	public String getContextName() {
		return "Relational Algebra Data Source";
	}

	@Override
	public DBSInstance getOwnerInstance() {
		return this;
	}

	@Override
	public boolean isConnected() {
		return true;
	}

	@Override
	public DBCSession openSession(DBRProgressMonitor monitor, DBCExecutionPurpose purpose, String task) {
		RelAlgebraUtils.log.debug("RelAlgebraDataSource open session");
		return new RelAlgebraSession(monitor, purpose, task, this);
	}

	@Override
	public void checkContextAlive(DBRProgressMonitor monitor) throws DBException {
		// do nothing
	}

	@Override
	public InvalidateResult invalidateContext(DBRProgressMonitor monitor, boolean closeOnFailure) throws DBException {
		throw new DBException("Connection invalidate not supported");
	}

	@Override
	public DBPDataSourceContainer getContainer() {
		return container;
	}

	@Override
	public DBPDataSourceInfo getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDataSourceFeature(String featureId) {
		return null;
	}

	@Override
	public void initialize(DBRProgressMonitor monitor) throws DBException {
		//final DBPConnectionConfiguration connectionInfo = container.getActualConnectionConfiguration();
		
	}

	@Override
	public DBCExecutionContext getDefaultContext(boolean meta) {
		return this;
	}

	@Override
	public DBCExecutionContext[] getAllContexts() {
        return new DBCExecutionContext[] { this };
	}

	@Override
	public DBCExecutionContext openIsolatedContext(DBRProgressMonitor monitor, String purpose) throws DBException {
		return this;
	}

	
}

