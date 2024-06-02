use std::io::stdin;

pub fn baekjoon_1547() {
    let mut field: Vec<i32> = vec![0, 1, 0, 0, 0];
    let mut n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    
    while n > 0 {
        n -= 1;
        
        let cup_vector: Vec<usize> = stdin().lines().next().unwrap().unwrap()
            .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
        let temp: i32 = field[cup_vector[1]];
        field[cup_vector[1]] = field[cup_vector[0]];
        field[cup_vector[0]] = temp;
    }
    
    let index = field.iter().position(|&x| x == 1).map(|x| x as i32).unwrap_or(-1);
    
    println!("{}", index);
}