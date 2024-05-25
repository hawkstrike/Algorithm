use std::cmp::min;
use std::fmt::Debug;
use std::io::{BufRead, stdin};

pub fn baekjoon_1463() {
    let mut input = stdin().lock().lines().next().unwrap().unwrap().trim().parse::<i32>().unwrap() as usize;
    let mut vector: Vec<i32> = vec![0; (input + 1) as usize];
    
    for i in 2..vector.len() {
        vector[i] = vector[i - 1] + 1;
        
        if i % 3 == 0 {
            vector[i] = min(vector[i / 3] + 1, vector[i]);
        }
        
        if i % 2 == 0 {
            vector[i] = min(vector[i / 2] + 1, vector[i]);
        }
    }
    
    println!("{}", vector[input]);
}