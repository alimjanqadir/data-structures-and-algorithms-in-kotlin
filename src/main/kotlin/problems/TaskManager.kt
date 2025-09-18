package problems

import java.util.PriorityQueue

class TaskManager(tasks: List<List<Int>>) {

  private data class TaskInfo(val userId: Int, var priority: Int)
  private data class HeapEntry(val priority: Int, val taskId: Int)

  private val taskById = HashMap<Int, TaskInfo>()

  private val maxHeap = PriorityQueue<HeapEntry> { a, b ->
    if (a.priority != b.priority) {
      b.priority.compareTo(a.priority)
    } else {
      b.taskId.compareTo(a.taskId)
    }
  }

  init {
    for (triple in tasks) {
      val userId = triple[0]
      val taskId = triple[1]
      val priority = triple[2]
      taskById[taskId] = TaskInfo(userId, priority)
      maxHeap.add(HeapEntry(priority, taskId))
    }
  }

  fun add(userId: Int, taskId: Int, priority: Int) {
    taskById[taskId] = TaskInfo(userId, priority)
    maxHeap.add(HeapEntry(priority, taskId))
  }

  fun edit(taskId: Int, newPriority: Int) {
    val info = taskById[taskId]!!
    info.priority = newPriority
    maxHeap.add(HeapEntry(newPriority, taskId))
  }

  fun rmv(taskId: Int) {
    taskById.remove(taskId)
  }

  fun execTop(): Int {
    while (maxHeap.isNotEmpty()) {
      val top = maxHeap.peek()
      val info = taskById[top.taskId]
      if (info == null) {
        maxHeap.poll()
        continue
      }
      if (info.priority != top.priority) {
        maxHeap.poll()
        continue
      }
      maxHeap.poll()
      taskById.remove(top.taskId)
      return info.userId
    }
    return -1
  }
}
