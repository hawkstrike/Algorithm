use std::io::stdin;

pub fn baekjoon_1978() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let prime_number_vector: Vec<i32> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    let mut count: i32 = 0;
    
    for &prime_number in prime_number_vector.iter() {
        let mut i = 2;
        let mut is_prime_number: bool = true;
        
        while i * i <= prime_number {
            if prime_number % i == 0 {
                is_prime_number = false;
            }
            
            i += 1;
        }
        
        if is_prime_number && prime_number != 1 {
            count += 1;
        }
    }
    
    println!("{}", count);
}