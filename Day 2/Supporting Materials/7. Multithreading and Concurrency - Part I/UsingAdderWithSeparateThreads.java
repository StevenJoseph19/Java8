package simple.adder;

public class UsingAdderWithSeparateThreads {

	public static void main(String[] args) throws InterruptedException {
		String[] inFiles = { "./file1.txt", "./file2.txt", "./file3.txt", "./file4.txt", "./file5.txt", "./file6.txt" };
		String[] outFiles = { "./file1.out.txt", "./file2.out.txt", "./file3.out.txt", "./file4.out.txt",
				"./file5.out.txt", "./file6.out.txt" };
		Thread[] threads = new Thread[inFiles.length];
		for (int i = 0; i < inFiles.length; i++) {
			AdderWithThreading adder = new AdderWithThreading(inFiles[i], outFiles[i]);
			threads[i] = new Thread(adder);
			threads[i].start();
		}

		for (Thread thread : threads)
			thread.join(); // Blocks waiting for thread completion

	}

}
