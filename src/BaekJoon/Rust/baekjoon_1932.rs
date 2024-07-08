use std::cmp::max;
use std::io::stdin;

pub fn baekjoon_1932() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut field: Vec<Vec<i32>> = vec![vec![0; n]; n];
    let mut dp: Vec<Vec<i32>> = vec![vec![0; n]; n];
    let mut max_number: i32 = 0;
    
    for i in 0..n {
        let line_vector: Vec<i32> = stdin().lines().next().unwrap().unwrap()
            .split_whitespace().map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        
        for j in 0..line_vector.len() {
            field[i][j] = line_vector[j];
        }
    }
    
    dp[0][0] = field[0][0];
    
    for i in 1..n {
        for j in 0..=i {
            if j == 0 {
                dp[i][j] = field[i][j] + dp[i - 1][j];
            } else if i == j {
                dp[i][j] = field[i][j] + dp[i - 1][j - 1];
            } else {
                dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + field[i][j];
            }
        }
    }
    
    for i in 0..n {
        max_number = max(max_number, dp[n - 1][i]);
    }
    
    println!("{}", max_number);
}