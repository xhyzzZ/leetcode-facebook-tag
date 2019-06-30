//leetcode 359 Logger Rate Limiter

/*
time: O(n)
space: O()
*/

class Logger {
    class TimeMsg {
	    int timestamp;
	    String msg;
	    public TimeMsg(int timestamp, String msg) {
	        this.timestamp = timestamp;
	        this.msg = msg;
	    }
	}
	/** Initialize your data structure here. */
	private static final int MAX_TIME_WINDOW = 10;
	Queue<TimeMsg> msgQueue;
	public Logger() {
	    msgQueue = new LinkedList<>();
	}
	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	    If this method returns false, the message will not be printed.
	    The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {  
	    while (!msgQueue.isEmpty() && timestamp - msgQueue.peek().timestamp >= MAX_TIME_WINDOW) {
	        msgQueue.poll();
	    }
	    Iterator<TimeMsg> iter = msgQueue.iterator();
	    while (iter.hasNext()) {
	        TimeMsg tm = iter.next();
	        if (tm.msg.equals(message)) return false;
	    }
	    msgQueue.offer(new TimeMsg(timestamp, message));
	    return true;
	}
}