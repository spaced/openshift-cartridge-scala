package com.example


class XMain extends xsbti.AppMain {
  def run (launchConfig: xsbti.AppConfiguration) = {
    class Running extends xsbti.Continue

    Boot.main(launchConfig.arguments)

    new Running()
  }
}
