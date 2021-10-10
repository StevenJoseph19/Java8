package com.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.File;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(BlockJUnit4ClassRunner.class)
public class TemporaryFolderRuleTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void whenNewFileCreatedThenAssertThatItExists() throws Exception {
		File medium = temporaryFolder.newFile("Medium.txt");
		assertThat(medium.exists(), is(true));
	}
}