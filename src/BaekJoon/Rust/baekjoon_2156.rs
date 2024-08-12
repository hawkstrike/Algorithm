use std::cmp::max;
use std::io::{BufRead, stdin};

pub fn baekjoon_2156() {
    let mut lines = stdin().lock().lines().map(|line| line.unwrap());
    let n: usize = lines.next().unwrap().trim().parse::<usize>().unwrap();
    let mut field: Vec<i32> = vec![0; n + 1];
    let mut dp: Vec<i32> = vec![0; n + 1];
    
    for index in 1..=n {
        field[index] = lines.next().unwrap().trim().parse::<i32>().unwrap();
    }
    
    dp[1] = field[1];
    
    if n >= 2 {
        dp[2] = field[1] + field[2];
    }
    
    for index in 3..=n {
        dp[index] = max(dp[index - 1], max(dp[index - 2] + field[index], dp[index - 3] + field[index] + field[index - 1]));
    }
    
    println!("{}", dp[n]);
}