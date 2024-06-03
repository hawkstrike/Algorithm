use std::io::stdin;

pub fn baekjoon_1551() {
    let n_k: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (n, k) = (n_k[0], n_k[1]);
    let mut sequence_vector: Vec<i32> = stdin().lines().next().unwrap().unwrap()
        .split(",").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    
    for _ in 0..k {
        let t: Vec<i32> = sequence_vector.windows(2).map(|w| w[1] - w[0]).collect();
        
        sequence_vector = t;
    }
    
    let output: Vec<String> = sequence_vector.iter().map(|i| i.to_string()).collect::<Vec<String>>();
    
    println!("{}", output.join(","));
}