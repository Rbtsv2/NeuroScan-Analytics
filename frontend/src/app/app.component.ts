import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseChartDirective } from 'ng2-charts';
import { HealthService } from './services/health.service';
import { ChartConfiguration, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, BaseChartDirective],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  healthData: any[] = [];

  // Configuration du graphique en barres
  public barChartOptions: ChartOptions<'bar'> = {
    responsive: true,
    plugins: {
      legend: { display: true },
      title: {
        display: true,
        text: 'Daily Steps par Personne'
      }
    }
  };

  // Spécifiez explicitement le type "bar"
  public barChartType: 'bar' = 'bar';

  public barChartData: ChartConfiguration<'bar'>['data'] = {
    labels: [],
    datasets: [
      {
        data: [],
        label: 'Daily Steps',
        backgroundColor: 'rgba(63,81,181,0.7)',
        hoverBackgroundColor: 'rgba(63,81,181,1)'
      }
    ]
  };

  @ViewChild(BaseChartDirective) chart!: BaseChartDirective;

  constructor(private healthService: HealthService) {}

  ngOnInit(): void {
    this.healthService.getHealthData().subscribe(
      (data: any) => {
        this.healthData = data;
        console.log("Données reçues depuis l'API :", this.healthData);
        this.populateChart();
      },
      (error: any) => {
        console.error("Erreur lors de la récupération des données", error);
      }
    );
  }

  populateChart(): void {
    const labels: string[] = [];
    const steps: number[] = [];
    this.healthData.forEach((item: any) => {
      labels.push(`ID ${item.personId}`);
      steps.push(item.dailySteps);
    });
    this.barChartData.labels = labels;
    this.barChartData.datasets[0].data = steps;

    if (this.chart) {
      this.chart.update();
    }
  }
}
