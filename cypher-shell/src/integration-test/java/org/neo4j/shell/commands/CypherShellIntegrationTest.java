package org.neo4j.shell.commands;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.neo4j.shell.ConnectionConfig;
import org.neo4j.shell.CypherShell;
import org.neo4j.shell.exception.CommandException;
import org.neo4j.shell.log.Logger;
import org.neo4j.shell.log.StdLogger;

import static junit.framework.TestCase.assertTrue;

public class CypherShellIntegrationTest {

    private Logger logger = new StdLogger();
    private CypherShell shell = new CypherShell(logger);
    private Command rollbackCommand = new Rollback(shell);
    private Command commitCommand = new Commit(shell);
    private Command beginCommand = new Begin(shell);

    @Before
    public void setUp() throws Exception {
        shell.connect(new ConnectionConfig("localhost", 7687, "neo4j", "neo"));
    }

    @After
    public void tearDown() throws Exception {
        shell.disconnect();
    }

    @Test
    public void rollbackScenario() throws CommandException {
        try {
            beginCommand.execute("");
            shell.execute("CREATE (:Random)");
            rollbackCommand.execute("");
            shell.execute("MATCH (n) RETURN n");
        } catch (CommandException e) {
            assertTrue("unexepcted error", e.getMessage().contains("Not connected"));
        }
    }

    @Test
    public void commitScenario() throws CommandException {
        try {
            beginCommand.execute("");
            shell.execute("CREATE (:Person {name: \"John Smith\"})");
            commitCommand.execute("");
        } catch (CommandException e) {
            assertTrue("unexepcted error", e.getMessage().contains("Not connected"));
        }
    }
}