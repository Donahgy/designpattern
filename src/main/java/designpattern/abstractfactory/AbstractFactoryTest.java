package designpattern.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDataUtils iDataUtils = new OracleDataUtil();
        IConnection connection = iDataUtils.getConnection();
        connection.connect();
        ICommand command = iDataUtils.getCommand();
        command.command();
    }
}

interface IConnection {
    void connect();
}

interface ICommand {
    void command();
}

interface IDataUtils {
    IConnection getConnection();

    ICommand getCommand();
}

class OracleConnect implements IConnection {

    @Override
    public void connect() {
        System.out.println("oracle connected ...");
    }
}

class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("oracle command ...");
    }
}

class OracleDataUtil implements IDataUtils {

    @Override
    public IConnection getConnection() {
        return new OracleConnect();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}

class MysqlConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("mysql connected ...");
    }
}

class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("mysql command ...");
    }
}

class MysqlDataUtil implements IDataUtils {

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

