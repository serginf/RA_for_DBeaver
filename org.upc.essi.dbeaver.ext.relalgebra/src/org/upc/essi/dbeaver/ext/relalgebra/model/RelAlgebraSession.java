package org.upc.essi.dbeaver.ext.relalgebra.model;

import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.DBPDataSource;
import org.jkiss.dbeaver.model.exec.DBCException;
import org.jkiss.dbeaver.model.exec.DBCExecutionContext;
import org.jkiss.dbeaver.model.exec.DBCExecutionPurpose;
import org.jkiss.dbeaver.model.exec.DBCStatement;
import org.jkiss.dbeaver.model.exec.DBCStatementType;
import org.jkiss.dbeaver.model.impl.AbstractSession;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.upc.essi.dbeaver.ext.relalgebra.RelAlgebraUtils;

public class RelAlgebraSession extends AbstractSession {
	
	private final RelAlgebraDataSource dataSource;

    public RelAlgebraSession(DBRProgressMonitor monitor, DBCExecutionPurpose purpose, String taskTitle, RelAlgebraDataSource dataSource)
    {
        super(monitor, purpose, taskTitle);
        this.dataSource = dataSource;
        RelAlgebraUtils.log.debug("Constructor de RelAlgebraSession");
    }
	
	@Override
	public DBCExecutionContext getExecutionContext() {
		return dataSource;
	}

	@Override
	public DBPDataSource getDataSource() {
		return dataSource;
	}

	@Override
	public DBCStatement prepareStatement(DBCStatementType type, String query, boolean scrollable, boolean updatable,
			boolean returnGeneratedKeys) throws DBCException {
		RelAlgebraUtils.log.debug("en prepare statement");
		RelAlgebraUtils.log.debug(query);

		
		return new RelAlgebraStatement(this, type, query);
	}

	@Override
	public void cancelBlock(DBRProgressMonitor monitor, Thread blockThread) throws DBException {
		// TODO Auto-generated method stub
	}

}
