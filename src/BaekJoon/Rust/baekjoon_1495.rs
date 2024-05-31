use std::io::stdin;

pub fn baekjoon_1495() {
    let n_s_m: Vec<usize> = stdin().lines().next().unwrap().unwrap().split_whitespace()
        .map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (n, s, m) = (n_s_m[0], n_s_m[1], n_s_m[2]);
    let mut dp: Vec<Vec<usize>> = vec![vec![0; m + 1]; n + 1];
    
    dp[0][s] = 1;
    
    let volumn_vector: Vec<i32> = stdin().lines().next().unwrap().unwrap().split_whitespace()
        .map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    
    for i in 0..n {
        let index: i32 = volumn_vector[i];
        
        for j in 0..=m as i32 {
            if dp[i][j as usize] == 1 {
                if j + index <= m as i32 {
                    dp[i + 1][(j + index) as usize] = 1;
                }
                
                if j - index >= 0 {
                    dp[i + 1][(j - index) as usize] = 1;
                }
            }
        }
    }
    
    let mut max: i32 = -1;
    
    for i in 0..=m {
        if dp[n][i] != 0 && max < i as i32 {
            max = i as i32;
        }
    }
    
    println!("{}", max);
}