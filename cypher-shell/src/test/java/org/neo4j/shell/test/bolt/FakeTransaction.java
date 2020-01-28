package org.neo4j.shell.test.bolt;

import org.neo4j.driver.Record;
import org.neo4j.driver.Statement;
import org.neo4j.driver.StatementResult;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Value;

import java.util.Map;

public class FakeTransaction implements Transaction {
    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void success() {

    }

    @Override
    public void failure() {

    }

    @Override
    public void close() {

    }

    @Override
    public StatementResult run(String query, Value parameters) {
        return null;
    }

    @Override
    public StatementResult run(String query, Map<String, Object> parameters) {
        return null;
    }

    @Override
    public StatementResult run(String query, Record parameters) {
        return null;
    }

    @Override
    public StatementResult run(String query) {
        return null;
    }

    @Override
    public StatementResult run(Statement statement) {
        return null;
    }
}
