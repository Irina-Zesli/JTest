package ru.stqa.pft.githab;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithabTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("b03dc1f70d7cdc43890465f951696f094cf9686c");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("Irina-Zesli", "JTest")).commits();
    for (RepoCommit commit: commits.iterate(new ImmutableMap.Builder<String,String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
