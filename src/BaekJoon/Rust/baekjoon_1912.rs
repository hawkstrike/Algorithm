use std::cmp::max;
use std::io::stdin;

pub fn baekjoon_1912() {
    let mut dp: Vec<i32> = vec![0; 100001];
    let mut max_number: i32 = i32::MIN;
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let sequence_vector: Vec<i32> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    
    for index in 1..=sequence_vector.len() {
        dp[index] = sequence_vector[index - 1];
        
        if dp[index - 1] + dp[index] > dp[index] {
            dp[index] = dp[index - 1] + dp[index];
        }
        
        max_number = max(max_number, dp[index]);
    }
    
    println!("{}", max_number);
}