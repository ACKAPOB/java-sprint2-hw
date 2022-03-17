package manager;

public class Managers {
    private Managers(){} //приватный класс

    public static TaskManager getDefaultTaskManager(){
        return new InMemoryTaskManager(getDefaultHistoryManager());
    }

    public static HistoryManager getDefaultHistoryManager() {
        return new InMemoryHistoryManager();
    }
}
