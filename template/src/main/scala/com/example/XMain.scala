package com.example


class XMain extends xsbti.AppMain {
  def run (launchConfig: xsbti.AppConfiguration) = {
    class Exit (val code: Int) extends xsbti.Exit

    Boot.main(launchConfig.arguments)

    new Exit (0)
  }

}
