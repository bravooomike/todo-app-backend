package pl.bravooomike.todo.task;

import java.time.OffsetDateTime;

public class TaskDateMethod {

    public static OffsetDateTime calculateEndDate(TaskDto taskDto, TaskEntity taskEntity) {
        if (!"zak".equals(taskDto.getTaskStatus().getCode())) {
            System.out.println("Zmiana na null");
            return null;
        } else if (!"zak".equals(taskEntity.getTaskStatus().getCode())){
            System.out.println("Zmiana na datę");
            return OffsetDateTime.now();
        } else {
            System.out.println("stara data");
            return taskEntity.getEndedDate();
        }
    }

//    public static void handleEndDate(TaskDto taskDto, TaskEntity taskEntity) {
//        if (taskDto.getTaskStatus().getCode() != "zak") {
//            taskEntity.setEndedDate(null);
//        } else if (taskEntity.getTaskStatus().getCode() != "zak"){
//            taskEntity.setEndedDate(OffsetDateTime.now());
//        }
//    }
}
