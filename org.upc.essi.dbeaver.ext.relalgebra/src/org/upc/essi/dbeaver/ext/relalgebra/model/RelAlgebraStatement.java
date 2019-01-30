package org.upc.essi.dbeaver.ext.relalgebra.model;

import java.util.List;

import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.exec.DBCException;
import org.jkiss.dbeaver.model.exec.DBCExecutionSource;
import org.jkiss.dbeaver.model.exec.DBCResultSet;
import org.jkiss.dbeaver.model.exec.DBCSession;
import org.jkiss.dbeaver.model.exec.DBCStatement;
import org.jkiss.dbeaver.model.exec.DBCStatementType;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.upc.essi.dbeaver.ext.relalgebra.RelAlgebraUtils;

public class RelAlgebraStatement implements DBCStatement {
	private RelAlgebraSession session;
    private DBCStatementType type;
    private String query;
    //private List<WMIObject> queryResult;
    private long firstRow;
    private long maxRows;
    private DBCExecutionSource source;

    public RelAlgebraStatement(RelAlgebraSession session, DBCStatementType type, String query)
    {
    	RelAlgebraUtils.log.debug("en constructor RelAlgebraStatement");

        this.session = session;
        this.type = type;
        this.query = query;
    }

	@Override
	public void cancelBlock(DBRProgressMonitor monitor, Thread blockThread) throws DBException {	
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DBCSession getSession() {
		return session;
	}

	@Override
	public String getQueryString() {
		return query;
	}

	@Override
	public DBCExecutionSource getStatementSource() {
		return source;
	}

	@Override
	public void setStatementSource(DBCExecutionSource source) {
		this.source = source;
	}

	@Override
	public boolean executeStatement() throws DBCException {
		RelAlgebraUtils.log.debug("execute the statement "+query);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addToBatch() throws DBCException {
		throw new DBCException("Batches not supported");
	}

	@Override
	public int[] executeStatementBatch() throws DBCException {
		throw new DBCException("Batches not supported");
	}

	@Override
	public DBCResultSet openResultSet() throws DBCException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBCResultSet openGeneratedKeysResultSet() throws DBCException {
		throw new DBCException("Not Implemented");
	}

	@Override
	public int getUpdateRowCount() throws DBCException {
		return -1;
	}

	@Override
	public boolean nextResults() throws DBCException {
		return false;
	}

	@Override
	public void setLimit(long offset, long limit) throws DBCException {
        this.firstRow = offset;
        this.maxRows = limit;		
	}

	@Override
	public Throwable[] getStatementWarnings() throws DBCException {
        return null;
	}

	@Override
	public void setStatementTimeout(int timeout) throws DBCException {
	}

}
