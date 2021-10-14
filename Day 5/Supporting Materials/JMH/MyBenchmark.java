/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.first.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2)
public class MyBenchmark {

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(MyBenchmark.class.getSimpleName()).forks(1).build();

		new Runner(opt).run();
	}
	/*
	 * @Benchmark public void testMethod1() { // This is a demo/sample template for
	 * building your JMH benchmarks. Edit as // needed. // Put your benchmark code
	 * here.
	 * 
	 * int a = 1; int b = 2; int sum = a + b; }
	 */

	/*
	 * @Benchmark @BenchmarkMode(Mode.Throughput) public void testMethod2() { //
	 * This is a demo/sample template for building your JMH benchmarks. Edit as
	 * needed. // Put your benchmark code here.
	 * 
	 * int a = 1; int b = 2; int sum = a + b; }
	 */

	/*
	 * @Benchmark @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.MINUTES)
	 * public void testMethod3() { // This is a demo/sample template for building
	 * your JMH benchmarks. Edit as needed. // Put your benchmark code here.
	 * 
	 * int a = 1; int b = 2; int sum = a + b; }
	 */

	@Benchmark
	public void testMethod4(Blackhole bh) {
		int[] array = new int[2000];
		bh.consume(array);
	}

	@Benchmark
	public void testMethod5(Blackhole bh) {
		String[] array = new String[2000];
		bh.consume(array);
	}
	
	/*
	 * @State(Scope.Thread) public static class MyState { public int a = 1; public
	 * int b = 2; public int sum ; }
	 * 
	 * 
	 * @Benchmark @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.MINUTES)
	 * public void testMethod6(MyState state) { state.sum = state.a + state.b; }
	 */
	
	
	
}
