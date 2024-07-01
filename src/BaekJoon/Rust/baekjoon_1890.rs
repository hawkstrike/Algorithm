use std::io::stdin;

pub fn baekjoon_1890() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut field: Vec<Vec<usize>> = Vec::new();
    let mut dp: Vec<Vec<i64>> = vec![vec![0; n]; n];
    
    for i in 0..n {
        field.push(stdin().lines().next().unwrap().unwrap()
            .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect());
    }
    
    dp[0][0] = 1;
    
    for i in 0..n {
        for j in 0..n {
            if field[i][j] == 0 {
                continue;
            }
            
            if i + field[i][j] < n {
                dp[i + field[i][j]][j] += dp[i][j];
            }
            
            if j + field[i][j] < n {
                dp[i][j + field[i][j]] += dp[i][j];
            }
        }
    }
    
    println!("{}", dp[n - 1][n - 1]);
}