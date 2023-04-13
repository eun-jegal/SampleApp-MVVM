<h1>MVVM Sample App</h1>
<p>
This sample app demonstrates an Android architecture pattern - MVVM(Model, View, ViewModel) using Coroutines, Flow, Retrofit and Dagger2. When the user presses the button on the main screen, the app requests for user datas and displays them in a recyclerView.
</p>
<p align="center">
  <img src="https://user-images.githubusercontent.com/57670625/227792457-50104c7b-b626-4e62-9769-26c3875040a3.gif" width="23%"/>
</p>
<h3>Sample app built with different architectures</h3>
<ul>
  <li><a href="https://github.com/eun-jegal/SampleApp-MVC">MVC Pattern</a></li>
  <li><a href="https://github.com/eun-jegal/SampleApp-MVP">MVP Pattern</a></li>
  <li><a href="https://github.com/eun-jegal/SampleApp-MVI">MVI Pattern</a></li>
</ul>
<br>

<!-- Tech Stack -->
<h2>Tech Stack</h2>
<ul>
<li>Minumum SDK Level: 21</li>
<li>100% Kotlin</li>
<li>Architecture
    <ul>
      <li>MVVM Pattern: Industry-recognized software architecure pattern supported by Google</li>
    </ul>
 </li>
<li><a href="https://developer.android.com/kotlin/coroutines">Coroutines</a>: Concurrency design pattern provided by Kotlin</li>
<li><a href="https://square.github.io/retrofit/">Retrofit</a>: Type-safe REST client for Android, Java and Kotlin developed by Square.  </li>
<li><a href="https://square.github.io/okhttp/">OkHttp</a> : 3rd party library sending and receive HTTP-based network requests built on top of the Okio library</li>
<li><a href="https://github.com/google/gson">GSON</a>: Java library that can be used to convert Java Objects into their JSON representation</li>
<li><a href="https://github.com/bumptech/glide">Glide</a>: Fast and efficient open source media management and image loading framework </li>
</ul>
<br>

<!-- MVVM Description -->
<h2>What is MVVM pattern?</h2>
<p>MVVM stands for Model-View-ViewModel. By separating multiple app components into three layers - UI, Domain and Data, the app is scalable, maintainable and testable.</p>
<ul>
  <li>Architectural Principles</li>
    <ul>
      <li>Separations of concerns</li>
      <li>Drive UI from data models</li>
      <li>Single source of truth</li>
      <li>Unidirectional Data Flow</li>
   </ul>
</ul>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/230802601-81201493-c2ad-4083-922e-bce14f1ad16c.jpg" width="85%"/>
</p>
<ul>
<li><b>Model</b>: Model is a layer for storing data. It is responsible for all business logics and communication with the database and network layers.</li>
<li><b>View</b>: View represents UI layer including activity and fragments. When user actions occur, View notifies ViewModel so that ViewModel can request data to Model.</li>
<li><b>ViewModel</b>: ViewModel acts as a communicator between View and Model. ViewModel requests data to Model responding to user actions and View observes ViewModel to update the UI.</li>
</ul>
<br>

<!-- App Architecture -->
<h2>App Architecture</h2>
<p>This sample app was built with MVVM pattern.</p>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/230802758-2f786765-666d-462f-a8b9-00db96c493ae.jpg" width="85%"/>
</p>
<h3>How MVVM works in this app</h3>
<p>The below diagram presents how the app responds according to an user interaction.</p>

<p align="center">
   <img src="" width="55%"/>
</p>
    
<!-- References -->
<h2>References</h2>
<p>The purpose of this project was to understand the core principles of the MVVM pattern. You can check out more information about MVVM in following links.</p>
<li><a href="https://www.geeksforgeeks.org/mvp-model-view-presenter-architecture-pattern-in-android-with-example/">MVP (Model View Presenter) Architecture Pattern in Android with Example</a></li>
<li><a href="https://medium.com/cr8resume/make-you-hand-dirty-with-mvp-model-view-presenter-eab5b5c16e42">Model View Presenter(MVP) in Android with a simple demo project</a></li>
<li><a href="https://www.kodeco.com/7026-getting-started-with-mvp-model-view-presenter-on-android">Getting Started with MVP (Model View Presenter) on Android</a></li>
<li><a href="https://androidwave.com/android-mvp-architecture-for-beginners-demo-app/">Android MVP Architecture for Beginners (Demo App)</a></li>
