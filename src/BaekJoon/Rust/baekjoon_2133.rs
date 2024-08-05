use std::io::stdin;

pub fn baekjoon_2133() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut dp: [i32; 31] = [0; 31];
    
    dp[0] = 1;
    dp[2] = 3;
    
    for i in (4..=30).step_by(2) {
        dp[i] = 3 * dp[i - 2];
        
        for j in (4..=i).step_by(2) {
            dp[i] += 2 * dp[i - j];
        }
    }
    
    println!("{}", dp[n]);
}