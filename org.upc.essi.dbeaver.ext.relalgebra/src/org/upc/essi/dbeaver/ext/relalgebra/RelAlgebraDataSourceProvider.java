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
package org.upc.essi.dbeaver.ext.relalgebra;

import org.jkiss.code.NotNull;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.*;
import org.jkiss.dbeaver.model.app.DBPPlatform;
import org.jkiss.dbeaver.model.connection.DBPConnectionConfiguration;
import org.jkiss.dbeaver.model.connection.DBPDriver;
import org.jkiss.dbeaver.model.connection.DBPDriverLibrary;
import org.jkiss.dbeaver.model.preferences.DBPPropertyDescriptor;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.upc.essi.dbeaver.ext.relalgebra.model.RelAlgebraDataSource;

import java.io.File;

public class RelAlgebraDataSourceProvider implements DBPDataSourceProvider {


    @Override
    public void init(@NotNull DBPPlatform platform)
    {
    }

    @Override
    public long getFeatures()
    {
        return FEATURE_SCHEMAS;
    }

    @Override
    public DBPPropertyDescriptor[] getConnectionProperties(
        DBRProgressMonitor monitor,
        DBPDriver driver,
        DBPConnectionConfiguration connectionInfo) throws DBException
    {
        return null;
    }

    @Override
    public String getConnectionURL(DBPDriver driver, DBPConnectionConfiguration connectionInfo)
    {
    	System.out.println("In RelAlgebraDataSourceProvider");
    	System.out.println("Connection URI is "+"jdbc:postgresql://"+connectionInfo.getHostName()+":"
    			+connectionInfo.getHostPort()+"/"+connectionInfo.getDatabaseName());
    	//jdbc:postgresql://{host}[:{port}]/[{database}]
    	return "jdbc:postgresql://"+connectionInfo.getHostName()+":"
    			+connectionInfo.getHostPort()+"/"+connectionInfo.getDatabaseName();
    }

    @NotNull
    @Override
    public DBPDataSource openDataSource(@NotNull DBRProgressMonitor monitor, @NotNull DBPDataSourceContainer container) throws DBException
    {
        return new RelAlgebraDataSource(container);
    }


}
