use std::io::stdin;

pub fn baekjoon_1546() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut score_vector: Vec<f64> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<f64>().unwrap()).collect::<Vec<f64>>();
    let mut average: f64 = 0.0;
    let mut max_number: f64 = 0.0;
    
    for index in 0..n {
        max_number = f64::max(max_number, score_vector[index]);
    }
    
    for index in 0..score_vector.len() {
        score_vector[index] = (score_vector[index] / max_number) * 100.0;
        average += score_vector[index];
    }
    
    average /= n as f64;
    
    println!("{}", average);
}