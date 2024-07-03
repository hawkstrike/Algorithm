use std::cmp::{max, min};
use std::io::stdin;

pub fn baekjoon_1915() {
    let n_m: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (n, m) = (n_m[0], n_m[1]);
    let mut dp: Vec<Vec<i32>> = vec![vec![0; m + 1]; n + 1];
    
    for i in 1..=n {
        let char_vector: Vec<char> = stdin().lines().next().unwrap().unwrap().chars().collect::<Vec<char>>();
        
        for j in 0..char_vector.len() {
            dp[i][j + 1] = char_vector[j] as u8 as i32 - 48;
        }
    }
    
    let mut area: i32 = 0;
    
    for i in 1..=n {
        for j in 1..=m {
            if dp[i][j] != 0 {
                dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
                area = max(area, dp[i][j]);
            }
        }
    }
    
    println!("{}", area * area);
}