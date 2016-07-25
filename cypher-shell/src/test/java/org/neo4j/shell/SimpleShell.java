package org.neo4j.shell;

import org.neo4j.driver.v1.exceptions.ClientException;
import org.neo4j.shell.log.Logger;

import javax.annotation.Nonnull;

public class SimpleShell extends TestShell {
    public static final String ERROR = "error";
    private String cypher;

    public SimpleShell(Logger logger) {
        super(logger);
    }

    public String cypher() {
        return cypher;
    }

    @Override
    protected void executeCypher(@Nonnull String cypher) {
        if (ERROR.equals(cypher)) {
            throw new ClientException(ERROR);
        }
        this.cypher = cypher;
    }
}