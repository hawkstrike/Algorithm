use std::io::stdin;

pub fn baekjoon_1010() {
    let mut dp: [[i32; 31]; 31] = [[0; 31]; 31];
    
    for index in 1..31 {
        dp[index][1] = index as i32;
    }
    
    for i in 2..31 {
        for j in 2..31 {
            if i == j {
                dp[i][j] = 1;
            } else {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            };
        }
    }
    
    let mut result: String = String::new();
    let mut t: String = String::new();
    
    stdin().read_line(&mut t).unwrap();
    
    let range: i32 = t.trim().parse().unwrap();
    
    for index in 0..range {
        let mut line: String = String::new();
        
        stdin().read_line(&mut line).unwrap();
        
        let mut vector: Vec<&str> = line.split_whitespace().collect();
        let a: usize = vector.get(0).unwrap().trim().parse::<usize>().unwrap();
        let b: usize = vector.get(1).unwrap().trim().parse::<usize>().unwrap();
        
        result.push_str(&format!("{}\n", dp[b][a]));
    }
    
    println!("{}", result);
}