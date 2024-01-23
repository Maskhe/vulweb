package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.MultiThreadsVulService;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author hjx
 * @since 2024/1/5
 */
@Service
public class MultiThreadsVulServiceImpl implements MultiThreadsVulService {
    @Override
    public void cmdExec(String cmd) {
        SubThread subThread = new SubThread(cmd);
        subThread.start();
    }
}

/**
 * 用于执行命令的子线程
 * @author hjx
 * @since 2023/1/5
 */
class SubThread extends Thread {
    private Thread thread;
    private final String cmd;
    SubThread(String cmd) {
        this.cmd = cmd;
    }
    @Override
    public synchronized void start() {
        if (this.thread == null) {
            thread = new Thread(this, "subprocess");
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("start subprocess");
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("stop subprocess");
    }
}